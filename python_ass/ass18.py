import pytest

# Function to compute power
def power(base, exponent):
    return base ** exponent

# Parameterized test using pytest
@pytest.mark.parametrize("base, exponent, expected", [
    (9, 2, 4),
    (2, 3, 8),
    (1, 9, 1),
    (0, 9, 0)
])
def testing(base, exponent, expected):
    assert power(base, exponent) == expected

# Run tests with: pytest <filename>.py